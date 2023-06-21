create table public.avatars
(
    id         varchar(255) not null
        primary key,
    image_data bytea
);

alter table public.avatars
    owner to postgres;
--

create table public.individual
(
    id               varchar(255) not null
        primary key,
    birth_date       date,
    country_of_birth varchar(255),
    full_name        varchar(255),
    gender           varchar(255),
    icp              varchar(255),
    name             varchar(255),
    patronymic       varchar(255),
    place_of_birth   varchar(255),
    surname          varchar(255),
    avatar_id        varchar(255),

    contacts_id      varchar(255),

    documents_id     varchar(255)

);

alter table public.individual
    owner to postgres;
--
create table public.rf_passport
(
    id              varchar(255) not null
        primary key,
    birthdate       date,
    birthplace      varchar(255),
    department      varchar(255),
    division        varchar(255),
    gender          varchar(255),
    legal_force     boolean,
    issued_date     date,
    issuedby        varchar(255),
    message         varchar(255),
    name            varchar(255),
    number          varchar(255) not null,
    passport_status varchar(255),
    patronymic      varchar(255),
    receipt_date    date,
    series          varchar(255) not null,
    surname         varchar(255),
    validate_date   date,
    document_id     varchar(255)

);

alter table public.rf_passport
    owner to postgres;

--
create table public.snils_doc
(
    id            varchar(255) not null
        primary key,
    issued_date   date,
    receipt_date  date,
    snils         varchar(255),
    validate_date date,
    document_id   varchar(255)

);

alter table public.snils_doc
    owner to postgres;
    owner to postgres;

--
create table public.address
(
    id                   varchar(255) not null
        primary key,
    addition_area_street varchar(255),
    address_name         varchar(255),
    building             varchar(255),
    city                 varchar(255),
    city_type            varchar(255),
    country              varchar(255),
    house                varchar(255),
    housing              varchar(255),
    province             varchar(255),
    province_type        varchar(255),
    region               varchar(255),
    region_type          varchar(255),
    settlement           varchar(255),
    settlement_type      varchar(255),
    street               varchar(255),
    street_type          varchar(255),
    zipcode              varchar(255),
    individual_id        varchar(255)

);

alter table public.address
    owner to postgres;
--
create table public.documents
(
    id                     varchar(255) not null
        primary key,
    deathcertdocs_id       varchar(255),

    individual_id          varchar(255),

    inndoc_id              varchar(255),

    pensionreferencedoc_id varchar(255),

    snilsdoc_id            varchar(255)

);

alter table public.documents
    owner to postgres;
--
create table public.emails
(
    id         varchar(255) not null
        primary key,
    email      varchar(255),
    contact_id varchar(255)

);

alter table public.emails
    owner to postgres;

--
create table public.categories
(
    id                 varchar(255) not null
        primary key,
    category           varchar(255),
    driving_license_id varchar(255)

);

alter table public.categories
    owner to postgres;
--
create table public.death_cert
(
    id          varchar(255) not null
        primary key,
    department  varchar(255),
    date        date,
    issued_date date         not null,
    message     varchar(255),
    number      varchar(255) not null,
    series      varchar(255) not null,
    document_id varchar(255)

);

alter table public.death_cert
    owner to postgres;
--
create table public.frgn_passport
(
    id              varchar(255) not null
        primary key,
    birthdate       date,
    birthplace      varchar(255),
    department      varchar(255),
    division        varchar(255),
    expiry_date     date,
    gender          varchar(255),
    legal_force     boolean,
    issued_date     date,
    issuedby        varchar(255),
    latin_name      varchar(255),
    latin_surname   varchar(255),
    message         varchar(255),
    name            varchar(255),
    number          varchar(255) not null,
    passport_status varchar(255),
    patronymic      varchar(255),
    receipt_date    date,
    series          varchar(255) not null,
    surname         varchar(255),
    validate_date   date,
    document_id     varchar(255)

);

alter table public.frgn_passport
    owner to postgres;
--
create table public.inn_doc
(
    id            varchar(255) not null
        primary key,
    birthdate     date,
    birthplace    varchar(255),
    department    varchar(255),
    division      varchar(255),
    gender        varchar(255),
    inn           varchar(255),
    issued        date,
    issuedby      varchar(255),
    name          varchar(255),
    patronymic    varchar(255),
    receipt_date  date,
    surname       varchar(255),
    validate_date date,
    document_id   varchar(255)

);

alter table public.inn_doc
    owner to postgres;
--
create table public.pension_reference
(
    id            varchar(255) not null
        primary key,
    birth_date    varchar(255),
    birth_place   varchar(255),
    department    varchar(255),
    doc_version   varchar(255),
    gender        varchar(255),
    issued_date   date,
    name          varchar(255),
    patronymic    varchar(255),
    receipt_date  date,
    surname       varchar(255),
    validate_date date,
    document_id   varchar(255)

);

alter table public.pension_reference
    owner to postgres;
--
create table public.phone_numbers
(
    id         varchar(255) not null
        primary key,
    phone      varchar(255),
    contact_id varchar(255)

);

alter table public.phone_numbers
    owner to postgres;
--
create table public.rf_driving_license
(
    id            varchar(255) not null
        primary key,
    birthdate     date,
    birthplace    varchar(255),
    country       varchar(255),
    department    varchar(255),
    experience    varchar(255),
    expirydate    date,
    gender        varchar(255),
    legal_force   boolean,
    issued_date   date,
    issued_by     varchar(255),
    message       varchar(255),
    name          varchar(255),
    number        varchar(255) not null,
    patronymic    varchar(255),
    receipt_date  date,
    series        varchar(255) not null,
    surname       varchar(255),
    validate_date date,
    document_id   varchar(255)

);

alter table public.rf_driving_license
    owner to postgres;
--
create table public.contact_medium
(
    id            varchar(255) not null
        primary key,
    individual_id varchar(255)

);

alter table public.contact_medium
    owner to postgres;


---------------

alter table ONLY public.individual
    add constraint fk495y6vtm1fcju11v2ast8dg0w
        foreign key (avatar_id) references public.avatars (id);

alter table ONLY public.individual
    add constraint fkq68mnj7kvwjhx53ytugm5vnv9
        foreign key (contacts_id) references public.contact_medium (id);

alter table ONLY public.individual
    add constraint fkfw6ukxf9mrmqpqda5tyn4xhmx
        foreign key (documents_id) references public.documents (id);


alter table ONLY public.rf_passport
    add constraint fk2nrttmhqivd66eyn6e7rh068p
        foreign key (document_id) references public.documents (id);

alter table ONLY public.snils_doc
    add constraint fkapep586mhopp92dp8u9mvr15c
        foreign key (document_id) references public.documents (id);

alter table ONLY public.address
    add constraint fkn4ev0lritti7kpot4129w4wl
        foreign key (individual_id) references public.documents (id);

alter table ONLY public.documents
    add constraint fk24snsnb7iiixx6edmw8wrhmbp
        foreign key (deathcertdocs_id) references public.death_cert (id);

alter table ONLY public.documents
    add constraint fk959pj4fn35c0hrhr2pb49eciv
        foreign key (individual_id) references public.individual (id);

alter table ONLY public.documents
    add constraint fkceqn6u8qjyqadi991kvdej5x3
        foreign key (inndoc_id) references public.inn_doc (id);

alter table ONLY public.documents
    add constraint fkm2gapas655x3n8pjc374f0ug6
        foreign key (pensionreferencedoc_id) references public.pension_reference (id);

alter table ONLY public.documents
    add constraint fkke3kjsryxpl0x97nqsf82k8lx
        foreign key (snilsdoc_id) references public.snils_doc (id);

alter table ONLY public.emails
    add constraint fkbmugwfh1iuxu489i9oefgnal0
        foreign key (contact_id) references public.contact_medium (id);

alter table ONLY public.categories
    add constraint fk5i0wprrhpqwb13qkk7vq0kv0f
        foreign key (driving_license_id) references public.rf_driving_license (id);

alter table ONLY public.death_cert
    add constraint fk14r36up8fkh829xo4ybwc98m5
        foreign key (document_id) references public.documents (id);

alter table ONLY public.frgn_passport
    add constraint fk5jcfh87tls0oa053rpr9vlp2r
        foreign key (document_id) references public.documents (id);

alter table ONLY public.inn_doc
    add constraint fkrxe0s2akikaf0phc9y1t9ufe0
        foreign key (document_id) references public.documents (id);

alter table ONLY public.pension_reference
    add constraint fkf114xgakuutf1f2xd905rijnb
        foreign key (document_id) references public.documents (id);

alter table ONLY public.phone_numbers
    add constraint fkn6bfgcalpl4vg4ibytnhnggy1
        foreign key (contact_id) references public.contact_medium (id);

alter table ONLY public.rf_driving_license
    add constraint fk52e5qedyv4wvop6ufy9veld6b
        foreign key (document_id) references public.documents (id);

alter table ONLY public.contact_medium
    add constraint fknse6dyox2ndxq0bgkif959wxq
        foreign key (individual_id) references public.individual (id);











