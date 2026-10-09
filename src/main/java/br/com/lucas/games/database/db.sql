CREATE SEQUENCE sq_tb_game
    START WITH 1
    INCREMENT BY 1
    NOCACHE;

CREATE TABLE tb_game (
    cd_game NUMBER(10) PRIMARY KEY,
    nm_game VARCHAR2(80) NOT NULL,
    nr_nota NUMBER(3,1),
    nr_ano NUMBER(4),
    dt_compra DATE,
    st_finalizado NUMBER(1) -- Oracle doest have boolean
);

/*
INSERT INTO TB_GAME (cd_game, nm_game, nr_nota, nr_ano, dt_compra, st_finalizado)
VALUES (1, "Hiades", 0, 0, 1, 0);*/
