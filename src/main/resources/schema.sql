create table if not exists survey (
    id bigint not null,
    survey_name varchar (255) not null,
    primary key (id)
    );

create table if not exists question (
    id bigint not null,
    question_description varchar (255) not null,
    primary key (id),
    surveys_id bigint not null,
    foreign key (surveys_id) references survey(id)
    );

