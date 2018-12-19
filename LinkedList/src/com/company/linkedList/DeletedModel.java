package com.company.linkedList;

public class DeletedModel<Item> {
    public Item getDeletedItem() {
        return deletedItem;
    }

    public void setDeletedItem(Item deletedItem) {
        this.deletedItem = deletedItem;
    }

    public boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    private Item deletedItem;
    private boolean isDeleted;
}
