#!/bin/bash
direc=$1
echo "Informacion obtenida: " > Informacion.txt
echo Iniciando analisis
echo "//////////////////////////" >> Informacion.txt
echo Nombre del dominio o IP analizado: $direc >> Informacion.txt
echo "//////////////////////////" >> Informacion.txt
echo "///Informacion obtenida con ping///" >> Informacion.txt
echo Obteniendo informacion con ping
ping $direc -c 4 >> Informacion.txt
echo "//////////////////////////" >> Informacion.txt
echo "///Informacion obtenida con nslookup///" >> Informacion.txt
echo Obteniendo informacion con nslookup
nslookup $direc >> Informacion.txt
echo "//////////////////////////" >> Informacion.txt
echo "///Informacion obtenida con whois///" >> Informacion.txt
echo Obteniendo informacion con whois
whois $direc >> Informacion.txt
echo "//////////////////////////" >> Informacion.txt
echo "///Informacion obtenida con traceroute///" >> Informacion.txt
echo Obteniendo informacion con traceroute
traceroute $direc >> Informacion.txt
echo "//////////////////////////" >> Informacion.txt
echo "///Informacion obtenida con sublist3r///" >> Informacion.txt
echo Obteniendo informacion con sublist3r
sublist3r -d $direc >> Informacion.txt
echo "//////////////////////////" >> Informacion.txt
echo "///Informacion obtenida con dnsrecon///" >> Informacion.txt
echo Obteniendo informacion con dnsrecon
dnsrecon -d $direc >> Informacion.txt
echo "//////////////////////////" >> Informacion.txt
echo "///Informacion obtenida con dnsmap///" >> Informacion.txt
echo Obteniendo informacion con dnsmap
dnsmap $direc >> Informacion.txt
echo Procesos terminados
echo Obtencion de informacion terminada
