create table ip_ranges(

        id SERIAL PRIMARY KEY ,
        start_ip VARCHAR(45),
        end_ip VARCHAR(45),
        city VARCHAR(100)

);

INSERT INTO ip_ranges (start_ip, end_ip, city)
VALUES ('127.168.0.1', '192.168.0.255', 'CityA');
