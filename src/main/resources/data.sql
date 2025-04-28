delete from products where id > 0;
delete from brands where id > 0;

INSERT INTO brands (id, brand_name, created_date, updated_date) VALUES (1, 'A', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO brands (id, brand_name, created_date, updated_date) VALUES (2, 'B', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO brands (id, brand_name, created_date, updated_date) VALUES (3, 'C', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO brands (id, brand_name, created_date, updated_date) VALUES (4, 'D', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO brands (id, brand_name, created_date, updated_date) VALUES (5, 'E', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO brands (id, brand_name, created_date, updated_date) VALUES (6, 'F', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO brands (id, brand_name, created_date, updated_date) VALUES (7, 'G', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO brands (id, brand_name, created_date, updated_date) VALUES (8, 'H', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO brands (id, brand_name, created_date, updated_date) VALUES (9, 'I', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO products (category_name, price, brand_id, created_date, updated_date) VALUES ('상의', 11200, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO products (category_name, price, brand_id, created_date, updated_date) VALUES ('아우터', 5500, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO products (category_name, price, brand_id, created_date, updated_date) VALUES ('바지', 4200, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO products (category_name, price, brand_id, created_date, updated_date) VALUES ('스니커즈', 9000, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO products (category_name, price, brand_id, created_date, updated_date) VALUES ('가방', 2000, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO products (category_name, price, brand_id, created_date, updated_date) VALUES ('모자', 1700, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO products (category_name, price, brand_id, created_date, updated_date) VALUES ('양말', 1800, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO products (category_name, price, brand_id, created_date, updated_date) VALUES ('액세서리', 2300, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO products (category_name, price, brand_id, created_date, updated_date) VALUES ('상의', 10500, 2, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO products (category_name, price, brand_id, created_date, updated_date) VALUES ('아우터', 5900, 2, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO products (category_name, price, brand_id, created_date, updated_date) VALUES ('바지', 3800, 2, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO products (category_name, price, brand_id, created_date, updated_date) VALUES ('스니커즈', 9100, 2, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO products (category_name, price, brand_id, created_date, updated_date) VALUES ('가방', 2100, 2, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO products (category_name, price, brand_id, created_date, updated_date) VALUES ('모자', 2000, 2, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO products (category_name, price, brand_id, created_date, updated_date) VALUES ('양말', 2000, 2, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO products (category_name, price, brand_id, created_date, updated_date) VALUES ('액세서리', 2200, 2, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO products (category_name, price, brand_id, created_date, updated_date) VALUES ('상의', 10000, 3, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO products (category_name, price, brand_id, created_date, updated_date) VALUES ('아우터', 6200, 3, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO products (category_name, price, brand_id, created_date, updated_date) VALUES ('바지', 3300, 3, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO products (category_name, price, brand_id, created_date, updated_date) VALUES ('스니커즈', 9200, 3, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO products (category_name, price, brand_id, created_date, updated_date) VALUES ('가방', 2200, 3, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO products (category_name, price, brand_id, created_date, updated_date) VALUES ('모자', 1900, 3, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO products (category_name, price, brand_id, created_date, updated_date) VALUES ('양말', 2200, 3, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO products (category_name, price, brand_id, created_date, updated_date) VALUES ('액세서리', 2100, 3, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO products (category_name, price, brand_id, created_date, updated_date) VALUES ('상의', 10100, 4, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO products (category_name, price, brand_id, created_date, updated_date) VALUES ('아우터', 5100, 4, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO products (category_name, price, brand_id, created_date, updated_date) VALUES ('바지', 3000, 4, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO products (category_name, price, brand_id, created_date, updated_date) VALUES ('스니커즈', 9500, 4, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO products (category_name, price, brand_id, created_date, updated_date) VALUES ('가방', 2500, 4, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO products (category_name, price, brand_id, created_date, updated_date) VALUES ('모자', 1500, 4, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO products (category_name, price, brand_id, created_date, updated_date) VALUES ('양말', 2400, 4, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO products (category_name, price, brand_id, created_date, updated_date) VALUES ('액세서리', 2000, 4, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO products (category_name, price, brand_id, created_date, updated_date) VALUES ('상의', 10700, 5, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO products (category_name, price, brand_id, created_date, updated_date) VALUES ('아우터', 5000, 5, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO products (category_name, price, brand_id, created_date, updated_date) VALUES ('바지', 3800, 5, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO products (category_name, price, brand_id, created_date, updated_date) VALUES ('스니커즈', 9900, 5, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO products (category_name, price, brand_id, created_date, updated_date) VALUES ('가방', 2300, 5, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO products (category_name, price, brand_id, created_date, updated_date) VALUES ('모자', 1800, 5, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO products (category_name, price, brand_id, created_date, updated_date) VALUES ('양말', 2100, 5, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO products (category_name, price, brand_id, created_date, updated_date) VALUES ('액세서리', 2100, 5, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO products (category_name, price, brand_id, created_date, updated_date) VALUES ('상의', 11200, 6, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO products (category_name, price, brand_id, created_date, updated_date) VALUES ('아우터', 7200, 6, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO products (category_name, price, brand_id, created_date, updated_date) VALUES ('바지', 4000, 6, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO products (category_name, price, brand_id, created_date, updated_date) VALUES ('스니커즈', 9300, 6, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO products (category_name, price, brand_id, created_date, updated_date) VALUES ('가방', 2100, 6, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO products (category_name, price, brand_id, created_date, updated_date) VALUES ('모자', 1600, 6, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO products (category_name, price, brand_id, created_date, updated_date) VALUES ('양말', 2300, 6, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO products (category_name, price, brand_id, created_date, updated_date) VALUES ('액세서리', 1900, 6, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO products (category_name, price, brand_id, created_date, updated_date) VALUES ('상의', 10500, 7, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO products (category_name, price, brand_id, created_date, updated_date) VALUES ('아우터', 5800, 7, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO products (category_name, price, brand_id, created_date, updated_date) VALUES ('바지', 3900, 7, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO products (category_name, price, brand_id, created_date, updated_date) VALUES ('스니커즈', 9000, 7, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO products (category_name, price, brand_id, created_date, updated_date) VALUES ('가방', 2200, 7, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO products (category_name, price, brand_id, created_date, updated_date) VALUES ('모자', 1700, 7, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO products (category_name, price, brand_id, created_date, updated_date) VALUES ('양말', 2100, 7, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO products (category_name, price, brand_id, created_date, updated_date) VALUES ('액세서리', 2000, 7, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO products (category_name, price, brand_id, created_date, updated_date) VALUES ('상의', 10800, 8, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO products (category_name, price, brand_id, created_date, updated_date) VALUES ('아우터', 6300, 8, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO products (category_name, price, brand_id, created_date, updated_date) VALUES ('바지', 3100, 8, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO products (category_name, price, brand_id, created_date, updated_date) VALUES ('스니커즈', 9700, 8, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO products (category_name, price, brand_id, created_date, updated_date) VALUES ('가방', 2100, 8, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO products (category_name, price, brand_id, created_date, updated_date) VALUES ('모자', 1600, 8, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO products (category_name, price, brand_id, created_date, updated_date) VALUES ('양말', 2000, 8, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO products (category_name, price, brand_id, created_date, updated_date) VALUES ('액세서리', 2000, 8, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO products (category_name, price, brand_id, created_date, updated_date) VALUES ('상의', 11400, 9, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO products (category_name, price, brand_id, created_date, updated_date) VALUES ('아우터', 6700, 9, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO products (category_name, price, brand_id, created_date, updated_date) VALUES ('바지', 3200, 9, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO products (category_name, price, brand_id, created_date, updated_date) VALUES ('스니커즈', 9500, 9, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO products (category_name, price, brand_id, created_date, updated_date) VALUES ('가방', 2400, 9, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO products (category_name, price, brand_id, created_date, updated_date) VALUES ('모자', 1700, 9, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO products (category_name, price, brand_id, created_date, updated_date) VALUES ('양말', 1700, 9, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO products (category_name, price, brand_id, created_date, updated_date) VALUES ('액세서리', 2400, 9, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);