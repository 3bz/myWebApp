FROM gradle:jdk11

COPY . /home/gradle

#RUN ["gradle", "check"]
ENTRYPOINT ["gradle", "run"]