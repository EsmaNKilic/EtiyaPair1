package com.etiya.ecommercedemopair1.business.constants;

public class Messages {
    public static class Category {
        public static final String CategoryExists = "categoryExists";
        public static final String CategoryDoesNotExistsWithGivenId = "categoryDoesNotExistsWithGivenId";
        public static final String ListedCategory = "listCategory";

        public static final String CategoryAdded = "categoryAdded";
        public static final String GetCategoryById = "getCategory";
        public static final String DeletedCategory = "categoryDeleted";
        public static final String UpdatedCategory = "categoryUpdated";
    }

    public static class Product {
        public static final String ProductAdded = "productAdded";
        public static final String ListedProduct = "productListed";
        public static final String DeletedProduct = "productDeleted";
        public static final String NoExistsProductById = "existsOneProductMessage";
        public static final String UpdatedProduct = "productUpdated";
        public static final String GetProductById = "getProduct";
    }

    public static class Order {
        public static final String OrderAdded = "orderAdded";
        public static final String ListedOrder = "orderListed";
        public static final String DeletedOrder = "orderDeleted";
        public static final String UpdatedOrder = "orderUpdated";
        public static final String GetOrderById = "getOrder";

    }
}
