package com.gildedrose;

import static com.gildedrose.Item.*;

class GildedRose {

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            switch (item.name) {
                case AGED_BRIE:
                    updateAgedBrie(item);
                    break;
                case BACKSTAGE_CONCERT:
                    updateBackstageConcert(item);
                    break;
                case SULFURAS:
                    updateSulfuras(item);
                    break;
                case CONJURED:
                    updateConjured(item);
                    break;
                default:
                    updateOther(item);
            }
        }
    }

    private void updateAgedBrie(Item item) {
        item.sellIn--;
        addQuality(item);
        if (isOutOfDate(item)) {
            addQuality(item);
        }
    }

    private void updateBackstageConcert(Item item) {
        item.sellIn--;
        addQuality(item);
        if (item.sellIn < 10) {
            addQuality(item);
        }
        if (item.sellIn < 5) {
            addQuality(item);
        }
        if (isOutOfDate(item)) {
            item.quality = 0;
        }
    }

    private void updateSulfuras(Item item) {
        item.quality = 80;
    }

    private void updateConjured(Item item) {
        item.sellIn--;
        minusQuality(item);
        minusQuality(item);
        if (isOutOfDate(item)) {
            minusQuality(item);
            minusQuality(item);
        }
    }

    private void updateOther(Item item) {
        item.sellIn--;
        minusQuality(item);
        if (isOutOfDate(item)) {
            minusQuality(item);
        }
    }

    private boolean isOutOfDate(Item item) {
        return item.sellIn < 0;
    }

    private void minusQuality(Item item) {
        if (item.quality > 0) {
            item.quality--;
        }
    }

    private void addQuality(Item item) {
        if (item.quality < MAX_QUALITY) {
            item.quality++;
        }
    }

}