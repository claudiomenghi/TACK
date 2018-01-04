FROM ubuntu:16.04

ENV DEBIAN_FRONTEND=noninteractive

ENTRYPOINT ["entrypoint.sh"]
# install git
RUN apt-get update  && apt-get install -y dialog apt-utils && apt-get install -y software-properties-common python-software-properties && apt-get install -y gradle && apt-get install -y time && apt-get install -y sbcl
RUN apt-get update && apt-get install -y git && apt-get -y install z3  && apt-get -y install vim


RUN add-apt-repository ppa:webupd8team/java
RUN echo "oracle-java8-installer shared/accepted-oracle-license-v1-1 select true" |  debconf-set-selections
RUN apt-get update && apt-get install -y oracle-java8-installer


WORKDIR usr/local/
RUN git clone https://github.com/fm-polimi/zot.git
WORKDIR ../../

RUN mkdir workspace
WORKDIR workspace/
RUN git clone https://github.com/claudiomenghi/TACK.git


WORKDIR TACK/checker/
RUN gradle fatJar
WORKDIR ../../


RUN  mv /workspace/TACK/checker/build/libs/checker-all.jar /workspace/tack.jar

ADD fischer fischer
ADD scalabilityScripts/runTack.sh  runTack.sh 
ADD scalabilityScripts/scalability.sh  scalability.sh 
ADD run_zot.sh run_zot.sh
COPY entrypoint.sh /usr/local/bin/