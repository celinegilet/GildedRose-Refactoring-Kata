package com.gildedrose;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GildedRoseTest {

    @Test
    public void updateQuality_withDexterity_should_sellInMinusOne_and_qualityMinusOne() {
        // Given
        GildedRose app = buildApp(new Item("+5 Dexterity Vest", 10, 20));
        // When
        app.updateQuality();
        // Then
        verifyItem(app, "+5 Dexterity Vest", 9, 19);
    }

    @Test
    public void updateQuality_withSulfuras_outOfTheDate_should_sellIn_0_and_quality_80() {
        // Given
        GildedRose app = buildApp(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
        // When
        app.updateQuality();
        // Then
        verifyItem(app, "Sulfuras, Hand of Ragnaros", 0, 80);
    }

    @Test
    public void updateQuality_withSulfuras_should_sellIn_Same_and_quality_80() {
        // Given
        GildedRose app = buildApp(new Item("Sulfuras, Hand of Ragnaros", -1, 80));
        // When
        app.updateQuality();
        // Then
        verifyItem(app, "Sulfuras, Hand of Ragnaros", -1, 80);
    }

    @Test
    public void updateQuality_withElixir_should_sellInMinusOne_and_qualityMinusOne() {
        // Given
        GildedRose app = buildApp(new Item("Elixir of the Mongoose", 5, 7));
        // When
        app.updateQuality();
        // Then
        verifyItem(app, "Elixir of the Mongoose", 4, 6);
    }

    @Test
    public void updateQuality_withElixir_outOfTheDate_should_sellIn_Minus1_and_quality_Minus2() {
        // Given
        GildedRose app = buildApp(new Item("Elixir of the Mongoose", 0, 5));
        // When
        app.updateQuality();
        // Then
        verifyItem(app, "Elixir of the Mongoose", -1, 3);
    }

    @Test
    public void updateQuality_withElixir_outOfTheDate_should_sellIn_Minus1_and_quality_Zero() {
        // Given
        GildedRose app = buildApp(new Item("Elixir of the Mongoose", 0, 1));
        // When
        app.updateQuality();
        // Then
        verifyItem(app, "Elixir of the Mongoose", -1, 0);
    }

    @Test
    public void updateQuality_withAgedBrie_should_sellInMinusOne_and_qualityPlusOne() {
        // Given
        GildedRose app = buildApp(new Item("Aged Brie", 2, 0));
        // When
        app.updateQuality();
        // Then
        verifyItem(app, "Aged Brie", 1, 1);
    }

    @Test
    public void updateQuality_withAgedBrie_outOfTheDate_should_sellIn_Minus1_and_quality_Plus2() {
        // Given
        GildedRose app = buildApp(new Item("Aged Brie", -1, 48));
        // When
        app.updateQuality();

        // Then
        verifyItem(app, "Aged Brie", -2, 50);
    }

    @Test
    public void updateQuality_withBackstageConcert_outOfTheDate_should_sellIn_Minus1_and_quality_0() {
        // Given
        GildedRose app = buildApp(new Item("Backstage passes to a TAFKAL80ETC concert", -1, 80));
        // When
        app.updateQuality();
        // Then
        verifyItem(app, "Backstage passes to a TAFKAL80ETC concert", -2, 0);
    }

    @Test
    public void updateQuality_withBackstageConcert_should_sellIn_Minus1_and_quality_Plus1() {
        // Given
        GildedRose app = buildApp(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
        // When
        app.updateQuality();
        // Then
        verifyItem(app, "Backstage passes to a TAFKAL80ETC concert", 14, 21);
    }

    @Test
    public void updateQuality_withBackstageConcert_withSellIn10_should_sellIn_Minus1_and_quality_Max50() {
        // Given
        GildedRose app = buildApp(new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49));
        // When
        app.updateQuality();
        // Then
        verifyItem(app, "Backstage passes to a TAFKAL80ETC concert", 9, 50);
    }

    @Test
    public void updateQuality_withBackstageConcert_withSellIn5_should_sellIn_Minus1_and_quality_Max50() {
        // Given
        GildedRose app = buildApp(new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49));
        // When
        app.updateQuality();
        // Then
        verifyItem(app, "Backstage passes to a TAFKAL80ETC concert", 4, 50);
    }

    @Test
    public void updateQuality_withBackstageConcert_withSellIn10_should_sellIn_Minus1_and_quality_Plus2() {
        // Given
        GildedRose app = buildApp(new Item("Backstage passes to a TAFKAL80ETC concert", 10, 40));
        // When
        app.updateQuality();
        // Then
        verifyItem(app, "Backstage passes to a TAFKAL80ETC concert", 9, 42);
    }

    @Test
    public void updateQuality_withBackstageConcert_withSellIn5_should_sellIn_Minus1_and_quality_Plus3() {
        // Given
        GildedRose app = buildApp(new Item("Backstage passes to a TAFKAL80ETC concert", 5, 40));
        // When
        app.updateQuality();
        // Then
        verifyItem(app, "Backstage passes to a TAFKAL80ETC concert", 4, 43);
    }

    @Test
    public void updateQuality_withBackstageConcert_withSellIn1_should_sellIn_Minus1_and_quality_Plus3() {
        // Given
        GildedRose app = buildApp(new Item("Backstage passes to a TAFKAL80ETC concert", 1, 40));
        // When
        app.updateQuality();
        // Then
        verifyItem(app, "Backstage passes to a TAFKAL80ETC concert", 0, 43);
    }

    @Test
    public void updateQuality_withConjured_should_sellIn_Minus1_and_quality_Minus2() {
        // Given
        GildedRose app = buildApp(new Item("Conjured Mana Cake", 3, 6));
        // When
        app.updateQuality();
        // Then
        verifyItem(app, "Conjured Mana Cake", 2, 4);
    }

    @Test
    public void updateQuality_withConjured_should_sellIn_Minus1_and_quality_Minus4() {
        // Given
        GildedRose app = buildApp(new Item("Conjured Mana Cake", 0, 6));
        // When
        app.updateQuality();
        // Then
        verifyItem(app, "Conjured Mana Cake", -1, 2);
    }

    private GildedRose buildApp(Item item) {
        return new GildedRose(new Item[] {item});
    }
    
    private void verifyItem(GildedRose app, String name, int sellIn, int quality) {
        Item item = app.items[0];
        assertThat(item.name).isEqualTo(name);
        assertThat(item.sellIn).isEqualTo(sellIn);
        assertThat(item.quality).isEqualTo(quality);
    }
    
}
