DELIMITER //

CREATE PROCEDURE llenar_tablas()
BEGIN
    DECLARE id_comp INT;
    DECLARE cod_comp VARCHAR(50);
    DECLARE nom_comp VARCHAR(100);
    DECLARE des_comp VARCHAR(255);
    DECLARE ver_id INT;
    DECLARE app_id INT;
    DECLARE ver VARCHAR(20);
    DECLARE ver_desc VARCHAR(255);
    DECLARE ver_comp_id INT;
    DECLARE comp_id INT;
    DECLARE ver_id_fk INT;
    DECLARE ver_comp_desc VARCHAR(255);
    DECLARE app_id_fk INT;
    DECLARE app_cod VARCHAR(50);
    DECLARE app_nom VARCHAR(100);
    DECLARE app_desc VARCHAR(255);
    
    DECLARE fin_cursor INT DEFAULT 0;
    
    DECLARE CTemporal CURSOR FOR 
        SELECT * FROM TMP_LLENAR_CAMPOS;
        
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET fin_cursor = 1;
    
    OPEN CTemporal;
    
    bucle_datos: LOOP
        FETCH CTemporal INTO 
            id_comp, cod_comp, nom_comp, des_comp,
            ver_id, app_id, ver, ver_desc,
            ver_comp_id, comp_id, ver_id_fk, ver_comp_desc,
            app_id_fk, app_cod, app_nom, app_desc;
        
        IF fin_cursor = 1 THEN
            LEAVE bucle_datos;
        END IF;
        
        INSERT IGNORE INTO application (app_id, app_code, app_name, app_description)
        VALUES (app_id_fk, app_cod, app_nom, app_desc);
        
        INSERT IGNORE INTO company (id_company, codigo_company, name_company, description_company)
        VALUES (id_comp, cod_comp, nom_comp, des_comp);
        
        INSERT IGNORE INTO version (version_id, app_id, version, version_description)
        VALUES (ver_id, app_id_fk, ver, ver_desc);
        
        INSERT IGNORE INTO version_company (version_company_id, company_id, version_id, version_company_description)
        VALUES (ver_comp_id, comp_id, ver_id_fk, ver_comp_desc);
        
    END LOOP bucle_datos;
    
    CLOSE CTemporal;
END //

DELIMITER ;
