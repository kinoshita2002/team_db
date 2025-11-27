SET foreign_key_checks=1;

USE teamdb;

INSERT INTO mst_user
(user_name, password, family_name, first_name, family_name_kana, first_name_kana, gender)
VALUES ('taro@gmail.com', '111111', '山田', '太郎', 'やまだ', 'たろう', 0);

INSERT INTO mst_category (category_name,category_description) VALUES
('ソファ','ソファです'),
('テーブル','テーブルです'),
('ベッド','ベッドです');

INSERT INTO mst_product(product_name,product_name_kana,product_description,category_id,price,image_full_path,release_date,release_company)VALUES 
('ブラックソファ','ぶらっくそふぁ','黒色のソファです',1,30000,'/img/blacksofa.jpg','2024/12/31','木下家具総本店'),
('グレイソファ','ぐれいそふぁ','グレイのソファです',1,35000,'/img/graysofa.jpg','2024/10/31','木下家具総本店'),
('ストーンテーブル','すとーんてーぶる','石で作ったテーブルです',2,20000,'/img/stonetable.jpg','2024/7/7','木下家具総本店'),
('ウッドテーブル','うっどてーぶる','木で作ったテーブルです',2,25000,'/img/woodtable.jpg','2024/12/25','木下家具総本店'),
('シングルベッド','しんぐるべっど','シングルサイズのベッドです',3,40000,'/img/singlebed.jpg','2024/12/24','木下家具総本店'),
('ダブルベッド','だぶるべっど','ダブルサイズのベッドです',3,50000,'/img/doublebed.jpg','2024/2/14','木下家具総本店');