FROM payara/micro:5.193
LABEL maintener="kazusato"

COPY build/libs/example-api-*.war /opt/payara/deployments

