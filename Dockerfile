FROM openjdk:8
COPY . /user/app
WORKDIR /user/app
RUN ["javac","SPS.java"]
ENTRYPOINT ["java" ,"SPS"]
MAINTAINER Prahlad J Shenoy <prahladjshenoy@gmail.com>
