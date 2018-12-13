package com.company.linkedList;

public class DeletedModel {
    public int getDeletedItem() {
        return deletedItem;
    }

    public void setDeletedItem(int deletedItem) {
        this.deletedItem = deletedItem;
    }

    public boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    private int deletedItem;
    private boolean isDeleted;
}
