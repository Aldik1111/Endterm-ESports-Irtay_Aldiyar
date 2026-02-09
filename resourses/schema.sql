create table if not exists games (
                                     id int primary key,
                                     name varchar(100) not null,
                                     genre varchar(20) not null
);

create table if not exists teams(
                                    id int primary key,
                                    name varchar(100) not null unique,
                                    game varchar(100)
);

create table if not exists players(
                                      id int primary key,
                                      nickname varchar(100) not null,
                                      age int,
                                      rank int,
                                      team_id int,
                                      foreign key (team_id) references teams(id)
);

create table if not exists tournaments (
                                           id int primary key,
                                           name varchar(100) not null,
                                           game_id int not null,
                                           foreign key (game_id) references games(id)
);

create table if not exists matches(
                                      id int primary key,
                                      tournament_id int not null,
                                      team1_id int not null,
                                      team2_id int not null,
                                      score1 int default(0),
                                      score2 int default(0),
                                      foreign key (tournament_id) references tournaments(id),
                                      foreign key (team1_id) references teams(id),
                                      foreign key (team2_id) references teams(id),
                                      check ( team1_id <> team2_id )
);

