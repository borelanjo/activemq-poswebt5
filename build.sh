#!/bin/bash
cd eureka && . build.sh && cd ..
cd gateway && . build.sh && cd ..
cd paciente-producer && . build.sh && cd ..
cd paciente-consumer && . build.sh && cd ..