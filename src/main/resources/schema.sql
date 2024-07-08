CREATE TABLE ELECTRONICS (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    productName VARCHAR(255),
    productDesc VARCHAR(255),
    price DECIMAL(8, 2),
    rating DECIMAL(2, 1) DEFAULT 0.0
);

CREATE TABLE REVIEWS (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    productId BIGINT,
    userName VARCHAR(255),
    userEmail VARCHAR(255),
    reviewScore DECIMAL(2, 1),
    FOREIGN KEY (productId) REFERENCES ELECTRONICS(id)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);

INSERT INTO electronics (productName, productDesc, price, rating)
VALUES ('Xbox Series X', 'Next-gen gaming console by Microsoft, with 4K gaming capability and high-speed SSD.', 499, 0.0);

INSERT INTO electronics (productName, productDesc, price, rating)
VALUES ('PlayStation 5', 'Sony''s latest gaming console with ray-tracing support and ultra-fast SSD.', 499, 0.0);

INSERT INTO electronics (productName, productDesc, price, rating)
VALUES ('Samsung 65" QLED 4K Smart TV', 'High-end smart TV with Quantum Dot technology for vibrant colors and smart features.', 1499, 0.0);

INSERT INTO electronics (productName, productDesc, price, rating)
VALUES ('iPhone 13 Pro', 'Apple''s flagship smartphone with Super Retina XDR display and A15 Bionic chip.', 999, 0.0);

INSERT INTO electronics (productName, productDesc, price, rating)
VALUES ('Bose QuietComfort 45 Headphones', 'Premium noise-canceling headphones with balanced audio performance.', 329, 0.0);

INSERT INTO electronics (productName, productDesc, price, rating)
VALUES ('iPad Air (5th Gen)', 'Apple''s mid-range tablet with Liquid Retina display and A14 Bionic chip.', 599, 0.0);

INSERT INTO electronics (productName, productDesc, price, rating)
VALUES ('Dell XPS 15 Laptop', 'High-performance laptop with 4K InfinityEdge display and Intel Core i7 processor.', 1499, 0.0);

INSERT INTO electronics (productName, productDesc, price, rating)
VALUES ('HP Spectre x360 Convertible', 'Stylish 2-in-1 laptop with OLED display and Intel Core i5 processor.', 1299, 0.0);

INSERT INTO electronics (productName, productDesc, price, rating)
VALUES ('ASUS ROG Strix G15 Gaming Laptop', 'Gaming laptop with AMD Ryzen 7 processor and NVIDIA GeForce RTX 3060 GPU.', 1299, 0.0);

INSERT INTO electronics (productName, productDesc, price, rating)
VALUES ('Apple MacBook Pro 14"', 'Professional-grade laptop with M1 Pro chip and Liquid Retina XDR display.', 1999, 0.0);

INSERT INTO electronics (productName, productDesc, price, rating)
VALUES ('Samsung Galaxy Tab S7+', 'Premium Android tablet with 12.4" Super AMOLED display and S Pen included.', 849, 0.0);

INSERT INTO electronics (productName, productDesc, price, rating)
VALUES ('Sony WH-1000XM4 Wireless Headphones', 'Industry-leading noise-canceling headphones with Hi-Res Audio and Alexa voice control.', 349, 0.0);

INSERT INTO electronics (productName, productDesc, price, rating)
VALUES ('LG OLED C1 55" 4K Smart TV', 'OLED TV with AI ThinQ and Dolby Vision IQ for cinematic viewing experience.', 1799, 0.0);

INSERT INTO electronics (productName, productDesc, price, rating)
VALUES ('Google Pixel 6 Pro', 'Google''s flagship smartphone with 6.7" 120Hz display and Tensor chip.', 899, 0.0);

INSERT INTO electronics (productName, productDesc, price, rating)
VALUES ('Microsoft Surface Pro 7', 'Versatile 2-in-1 tablet with Intel Core i5 processor and detachable keyboard.', 899, 0.0);

INSERT INTO electronics (productName, productDesc, price, rating)
VALUES ('Corsair Vengeance RGB Pro RAM (32GB)', 'High-performance DDR4 RAM with RGB lighting for gaming PCs.', 199, 0.0);

INSERT INTO electronics (productName, productDesc, price, rating)
VALUES ('Bose SoundLink Revolve+ Bluetooth Speaker', 'Portable Bluetooth speaker with 360-degree sound and water-resistant design.', 299, 0.0);

INSERT INTO electronics (productName, productDesc, price, rating)
VALUES ('Canon EOS R6 Mirrorless Camera', 'Full-frame mirrorless camera with 20.1MP sensor and 4K video recording.', 2499, 0.0);

INSERT INTO electronics (productName, productDesc, price, rating)
VALUES ('Nintendo Switch OLED Model', 'Upgraded version of the popular gaming console with OLED screen and enhanced audio.', 349, 0.0);

INSERT INTO electronics (productName, productDesc, price, rating)
VALUES ('Alienware Aurora R12 Gaming Desktop', 'High-performance gaming desktop with Intel Core i7 processor and NVIDIA GeForce RTX 3080 GPU.', 1999, 0.0);
