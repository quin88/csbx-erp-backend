ALTER TABLE jsh_material_category ADD COLUMN type VARCHAR(20);
UPDATE jsh_material_category SET type = '冷链' WHERE type IS NULL;
