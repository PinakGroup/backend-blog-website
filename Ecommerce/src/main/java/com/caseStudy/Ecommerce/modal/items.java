package com.caseStudy.Ecommerce.modal;


    import javax.persistence.*;
import java.io.Serializable;
    @Entity
    public class items implements Serializable {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long product_id;

        public long getProduct_id() {
            return product_id;
        }

        public void setProduct_id(long productId1) {
            product_id = productId1;
        }

        public String getName() {
            return name;
        }

        public void setName(String name1) {
            name = name1;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price1) {
            price = price1;
        }

        public String getDetails() {
            return Details;
        }

        public void setDetails(String details) {
            Details = details;
        }

        public String getImage() {
            return Image;
        }

        public void setImage(String image) {
            Image = image;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category1) {
            category = category1;
        }

        public String getSubCategory() {
            return SubCategory;
        }

        public void setSubCategory(String subCategory) {
            SubCategory = subCategory;
        }

        public int getActive() {
            return active;
        }

        public void setActive(int active) {
            this.active = active;
        }

        public com.caseStudy.Ecommerce.modal.itemDetails getItemDetails() {
            return itemDetails;
        }

        public void setItemDetails(com.caseStudy.Ecommerce.modal.itemDetails itemDetails) {
            this.itemDetails = itemDetails;
        }

        private String name;
        private double price;
        private String Details;
        private String Image;
        private String category;
        private String SubCategory;
        @Column(nullable = false, columnDefinition = "int default '1'")
        private int active;
        @Embedded
        private com.caseStudy.Ecommerce.modal.itemDetails itemDetails;

        items() {

        }
    }


