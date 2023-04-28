package com.etiya.ecommercedemopair1.business.concrate;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CategoryManagerTest {

    @BeforeEach
    void setUp() {
        // Her test öncesi çalıştırılacak alan
    }

    @AfterEach
    void tearDown() {
        // Her test sonrası çalıştırılacak alan
    }

    @Test
    void add() {
        // deneme
        // 3A Principle ↓
        // Arrange => Test yapılacak ortamı hazırlar, mock objelerin oluşturulması, bağımlılıkların yüklenmesi
        // Act(Action) => CategoryManager.add(); test edeceğin metodun işleme alınması
        // Assert(Beklenti) => Expected durum ile Real durum karşılaştırmasının yapıldığı nokta => categoryManager.add().throwsException() ? boolean
    }
}