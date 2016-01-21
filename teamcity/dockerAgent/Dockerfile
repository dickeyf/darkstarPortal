FROM ubuntu:14.04

RUN sudo apt-get update && sudo apt-get install -y curl && curl -sL https://deb.nodesource.com/setup_5.x | sudo -E bash -
RUN sudo apt-get install -y nodejs git && npm install -g bower && npm install -g phantomjs && npm install -g ember-cli@2.2.0-beta.6
RUN mkdir /teamcity && cd /teamcity
ADD agent.tar.gz /teamcity/
ADD jdk-8u71-linux-x64.gz /teamcity/
ADD start.sh /teamcity/
COPY buildAgent.properties /teamcity/agent/conf/buildAgent.properties

WORKDIR /teamcity/agent

CMD ["/teamcity/run.sh"]
