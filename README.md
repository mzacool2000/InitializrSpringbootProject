# InitializrSpringbootProject
 MyCar

#get
http://localhost:8080/cars/all
http://localhost:8080/maintenance/all
http://localhost:8080/truck/all

http://localhost:8080/cars/{id}
http://localhost:8080/maintenance/{id}
http://localhost:8080/truck/{id}

#post
http://localhost:8080/cars/add
{
"licensePlate": "AAA-117",
"branch": "Ford",
"model": "ciena",
"modelYear": 2020,
"mileage": 5000,
"cylinderCapacity": 4,
"carType": "SPORTS_CAR",
"numberOfDoors": 3,
"capacity": 6,
"trunkCapacity": 8.54
}

http://localhost:8080/maintenance/add

{
"maintenanceId": "a818a36b-38c8-4b04-b593-f4f705311a8e",
"notes": "sound chonk chonk",
"dateCreate": "2022-03-03T19:03:01.000+00:00",
"isDelete": null,
"dateOfDelete": null,
"vehicleModel": {
"id": "1314620c-6522-451f-b04a-0d8cdbaca585",
"licensePlate": "AAA-117",
"branch": "Ford",
"model": "ciena",
"modelYear": 2020,
"mileage": 5000,
"cylinderCapacity": 4
}
}

http://localhost:8080/truck/add
{
"licensePlate": "AAA-582",
"branch": "loco",
"model": "XR4",
"modelYear": 2020,
"mileage": 20000,
"cylinderCapacity": 12,
"type": "CEMENT_TRUCK",
"numberOfAxles": 9
}

#put
http://localhost:8080/cars/edit
{
"id": "5ac03d00-0883-4d3c-a5b2-90c6f56d8ba7",
"licensePlate": "AAA-113",
"branch": "Fiat",
"model": "Spazio",
"modelYear": 2028,
"mileage": 15000,
"cylinderCapacity": 7,
"carType": "SPORTS_CAR",
"numberOfDoors": 4,
"capacity": 6,
"trunkCapacity": 8.54
}
http://localhost:8080/maintenance/edit
{
"maintenanceId": "a818a36b-38c8-4b04-b593-f4f705311a8e",
"notes": "sound chonk chonk",
"dateCreate": "2022-03-03T19:03:01.000+00:00",
"isDelete": null,
"dateOfDelete": null,
"vehicleModel": {
"id": "0d9c734b-e080-429c-b6d1-86286f76394c",
"licensePlate": "AAA-111",
"branch": "ford",
"model": "ka",
"modelYear": 2019,
"mileage": 2500,
"cylinderCapacity": 2.5
}
}
http://localhost:8080/truck/edit
{
"id": "0201e3f5-8ed9-4025-bf59-014f1902e502",
"licensePlate": "AAA-282",
"branch": "Scania",
"model": "XR4",
"modelYear": 2021,
"mileage": 20000,
"cylinderCapacity": 12,
"type": "CEMENT_TRUCK",
"numberOfAxles": 9
}

#>Delet
http://localhost:8080/cars/delete/{id}
http://localhost:8080/truck/delete/{id}
