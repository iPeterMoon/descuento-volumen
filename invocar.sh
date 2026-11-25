#!/usr/bin/env bash
# Invoca descuento-volumen corriendo en contenedor (Docker o Kubernetes).
# Uso: bash invocar.sh http://localhost:9000     (con docker compose up)
#      bash invocar.sh <URL>                     (Kubernetes: la URL que imprime
#                                                 "minikube service descuento --url" en otra terminal)
URL=${1:-http://localhost:9000}
curl -s "$URL/2015-03-31/functions/function/invocations" \
  -d '{"unidades":150,"precioCentavos":2500}'
echo
