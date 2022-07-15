#!/bin/bash

ORIG=$(/bin/grep -o 'Categoty: \(.*\)' $1)

INC=$( echo $ORIG | awk -F 'Categoty: ' '{ print $2; }' | \
          awk '{n=split($0,a,", "); for (i = 1; i < n; i++) { printf "\"%s\", ", a[i]; }}')

I=${INC::-2}
NEW="Categoty: \[$I\]"

echo sed -i "s/${ORIG}/${NEW}/g" $1
