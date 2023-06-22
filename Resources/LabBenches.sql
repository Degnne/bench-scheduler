DROP TABLE IF EXISTS person_day_schedule,person_trained_bench, bench_day_requirements, person, bench;

CREATE TABLE person (
	person_id serial primary key,
	first_name varchar(36) not null,
	last_name varchar(36) not null
);

CREATE TABLE bench (
	bench_id serial primary key,
	bench_name varchar(64) NOT NULL
);

CREATE TABLE person_trained_bench (
	person_id bigint NOT NULL,
	bench_id bigint NOT NULL,
	
	CONSTRAINT pk_person_trained_bench PRIMARY KEY (person_id, bench_id),
	CONSTRAINT fk_person_trained_bench_person_id FOREIGN KEY (person_id) REFERENCES person(person_id),
	CONSTRAINT fk_person_trained_bench_bench_id FOREIGN KEY (bench_id) REFERENCES bench(bench_id)
);

CREATE TABLE bench_day_requirements (
	bench_id bigint NOT NULL,
	day date NOT NULL,
	required_people int,
	
	CONSTRAINT pk_bench_day_requirements PRIMARY KEY (bench_id, day),
	CONSTRAINT fk_bench_day_requirements_bench_id FOREIGN KEY (bench_id) REFERENCES bench(bench_id)
);

CREATE TABLE person_day_schedule (
	person_id bigint NOT NULL,
	day date NOT NULL,
	bench_id bigint,
	is_working boolean,
	
	CONSTRAINT pk_person_day_schedule PRIMARY KEY (person_id, day),
	CONSTRAINT fk_person_day_schedule_person_id FOREIGN KEY (person_id) REFERENCES person(person_id),
	CONSTRAINT fk_person_day_schedule_bench_id FOREIGN KEY (bench_id) REFERENCES bench(bench_id)
);