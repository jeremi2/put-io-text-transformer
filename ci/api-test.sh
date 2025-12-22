#!/bin/bash

echo "Starting application..."
nohup java -jar target/*.jar >app.log 2>&1 &
APP_PID=$!

echo "Waiting for Spring Boot to start..."
sleep 15

echo "Creating request.json file..."
echo '{"text": "ala ma kota", "transforms": ["upper", "repetition"]}' >request.json

echo "Sending CURL request using request.json..."
RESPONSE=$(curl -s -X POST http://localhost:8080/transform \
    -H "Content-Type: application/json" \
    -d @request.json)

echo "Response received: $RESPONSE"

kill $APP_PID
rm request.json

if [[ "$RESPONSE" == *"ALA MA KOTA"* ]]; then
    echo "TEST PASSED"
    exit 0
else
    echo "TEST FAILED"
    echo "--- Application Logs ---"
    cat app.log
    exit 1
fi
