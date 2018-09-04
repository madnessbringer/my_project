cd c:\
mkdir tmp
wmic csproduct get name > c:/tmp/NB.txt
wmic OS GET Name ,VERSION > c:/tmp/OS.txt
wmic baseboard get Manufacturer ,product > c:/tmp/MB.txt
wmic cpu get name > c:/tmp/CPU.txt
wmic path win32_videocontroller get name > c:tmp/VC.txt
wmic memorychip get Manufacturer,Capacity,PartNumber,Speed > c:/tmp/RAM.txt
wmic diskdrive get model ,size > c:/tmp/HD.txt
wmic nic get adaptertype ,name, macaddress > c:/tmp/NA.txt
wmic printer  get name > c:/tmp/P.txt


exit


