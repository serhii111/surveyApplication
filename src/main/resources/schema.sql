create table if not exists survey (
    id bigint not null,
    survey_name varchar (255) not null,
    primary key (id)
    );

create table if not exists question (
    id bigint not null,
    question_description varchar (255) not null,
    primary key (id),
    survey_id bigint not null,
    foreign key (survey_id) references survey(id)
    );

create table if not exists answer (
    id bigint not null,
    answer_description varchar (255) not null,
    answered boolean,
    primary key (id),
    question_id bigint not null,
    foreign key (question_id) references survey(id)
    );

