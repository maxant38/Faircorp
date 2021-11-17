
     INSERT INTO BUILDING(id,name) VALUES(3,'Administration');
     INSERT INTO BUILDING(id,name) VALUES(2,'Gymnase');
     INSERT INTO BUILDING(id,name) VALUES(4,'Secrétariat');


    INSERT INTO ROOM(id, name, floor, current_temperature, target_temperature, building_id) VALUES(-10, 'Vestiaire 1', 1, 22.3, 20.0,2);
    INSERT INTO ROOM(id, name, floor, current_temperature, target_temperature, building_id) VALUES(-7, 'Vestiaire 2', 1, 22.3, 20.0,2);
    INSERT INTO ROOM(id, name, floor, current_temperature, target_temperature, building_id) VALUES(-6, 'Salle de tennis', 1, 22.3, 20.0,2);
    INSERT INTO ROOM(id, name, floor, current_temperature, target_temperature, building_id) VALUES(-5, 'Salle de Conférence', 1, 22.3, 20.0,3);
    INSERT INTO ROOM(id, name, floor, current_temperature, target_temperature, building_id) VALUES(-4, 'Toilettes', 1, 22.3, 20.0,3);
    INSERT INTO ROOM(id, name, floor, current_temperature, target_temperature, building_id) VALUES(-3, 'Bureau 1', 1, 22.3, 20.0,3);
    INSERT INTO ROOM(id, name, floor, current_temperature, target_temperature, building_id) VALUES(-2, 'Entrée', 1, 22.3, 20.0,4);
    INSERT INTO ROOM(id, name, floor, current_temperature, target_temperature, building_id) VALUES(-1, 'waiting room', 1, 22.3, 20.0,4);


    INSERT INTO HEATER(id, heater_status, name, power, room_id) VALUES(-10, 'ON', 'Heater1', 2000, -10);
    INSERT INTO HEATER(id, heater_status, name, power, room_id) VALUES(-9, 'ON', 'Heater2', null, -10);

    INSERT INTO RWINDOW(id, window_status, name, room_id) VALUES(-10, 'CLOSED', 'Window 1', -10);
    INSERT INTO RWINDOW(id, window_status, name, room_id) VALUES(-9, 'CLOSED', 'Window 2', -10);
    INSERT INTO RWINDOW(id, window_status, name, room_id) VALUES(-8, 'OPEN', 'Window 3', -7);
    INSERT INTO RWINDOW(id, window_status, name, room_id) VALUES(-7, 'CLOSED', 'Window 4', -7);
    INSERT INTO RWINDOW(id, window_status, name, room_id) VALUES(-6, 'CLOSED', 'Window 5', -6);
    INSERT INTO RWINDOW(id, window_status, name, room_id) VALUES(-5, 'CLOSED', 'Window 6', -6);
    INSERT INTO RWINDOW(id, window_status, name, room_id) VALUES(-4, 'CLOSED', 'Window 8', -5);
    INSERT INTO RWINDOW(id, window_status, name, room_id) VALUES(-3, 'CLOSED', 'Window 7', -5);
    INSERT INTO RWINDOW(id, window_status, name, room_id) VALUES(-2, 'CLOSED', 'Window 9', -5);
    INSERT INTO RWINDOW(id, window_status, name, room_id) VALUES(-11, 'CLOSED', 'Window 11', -4);
    INSERT INTO RWINDOW(id, window_status, name, room_id) VALUES(-12, 'CLOSED', 'Window 12', -4);
    INSERT INTO RWINDOW(id, window_status, name, room_id) VALUES(-13, 'CLOSED', 'Window 13', -3);
    INSERT INTO RWINDOW(id, window_status, name, room_id) VALUES(-14, 'CLOSED', 'Window 14', -3);
    INSERT INTO RWINDOW(id, window_status, name, room_id) VALUES(-15, 'CLOSED', 'Window 15', -1);



