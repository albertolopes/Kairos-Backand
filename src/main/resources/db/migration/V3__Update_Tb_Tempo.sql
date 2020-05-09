DROP TABLE IF EXISTS TB_TEMPO cascade ;
CREATE TABLE TB_TEMPO(
    ID_TEMPO bigint GENERATED BY DEFAULT AS IDENTITY primary key,
    TEMPO_INICIAL timestamp without time zone,
    TEMPO_FINAL timestamp without time zone
);