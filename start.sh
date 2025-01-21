#!/bin/bash

# Démarrage du backend
echo "Starting backend..."
(cd backend && ./mvnw spring-boot:run) &

# Démarrage du frontend
echo "Starting frontend..."
(cd frontend && npm start)
