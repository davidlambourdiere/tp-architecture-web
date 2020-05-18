ALTER TABLE residence ADD name VARCHAR(255);
UPDATE `lifetech`.`residence` SET `name` = 'Residence Avenue Paris' WHERE (`id` = '1');