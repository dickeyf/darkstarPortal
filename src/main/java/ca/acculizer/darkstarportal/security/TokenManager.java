package ca.acculizer.darkstarportal.security;

import ca.acculizer.darkstarportal.model.Account;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

/**
 * Created by Francois Dickey on 2016-01-19.
 */
public class TokenManager implements Runnable {
    private static final int EXPIRY_TIME_MS = (int) TimeUnit.MINUTES.toMillis(30);
    private static final int TICK_TIME_MS = (int) TimeUnit.SECONDS.toMillis(5);
    private LinkedList<Token> tokens = new LinkedList<Token>();
    private HashMap<String, Token> tokenIdToToken = new HashMap<String, Token>();
    private HashMap<Long, Token> accountIdToToken = new HashMap<Long, Token>();
    private Thread ticker;
    private boolean stopping;

    public TokenManager() {
        ticker = new Thread(this);
        stopping = false;
    }

    public void start() {
        stopping = false;
        ticker.start();
    }

    public void stop() throws InterruptedException {
        stopping = true;
        ticker.interrupt();
        ticker.join();
    }

    public synchronized Token getTokenForAccount(Account account) {
        if (accountIdToToken.containsKey(account.getId())) {
            Token token = accountIdToToken.get(account.getId());
            token.kickExpiry();
            return token;
        } else {
            Token token = new Token(account, EXPIRY_TIME_MS);
            tokens.add(token);
            tokenIdToToken.put(token.getToken(), token);
            accountIdToToken.put(account.getId(), token);
            return token;
        }
    }

    public synchronized void logout(String tokenId) {
        Token token = tokenIdToToken.get(tokenId);
        Account account = token.getAccount();
        accountIdToToken.remove(account.getId());
        tokenIdToToken.remove(tokenId);
        tokens.remove(token);
    }

    @Override
    public void run() {
        while (!stopping) {
            try {
                Thread.sleep(TICK_TIME_MS);
            } catch (InterruptedException e) {
                continue;
            }
            synchronized (this) {
                for (Token token : tokens) {
                    if (token.expires(TICK_TIME_MS)) {
                        logout(token.getToken());
                    }
                }
            }
        }
    }
}
