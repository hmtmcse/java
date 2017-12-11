package com.hmtmcse;

import javax.management.openmbean.SimpleType;

public class TextMinify {

    public static void main(String[] args) {
        String sql = "CREATE TABLE `shipment` (\n" +
                "  `id` bigint(20) NOT NULL AUTO_INCREMENT,\n" +
                "  `created` datetime NOT NULL,\n" +
                "  `method` varchar(255) NOT NULL,\n" +
                "  `order_id` bigint(20) NOT NULL,\n" +
                "  `shipping_date` datetime NOT NULL,\n" +
                "  `tracking_info` varchar(255) DEFAULT NULL,\n" +
                "  `updated` datetime NOT NULL,\n" +
                "  PRIMARY KEY (`id`),\n" +
                "  KEY `FK_p06cong2injx54ipykoegys3w` (`order_id`),\n" +
                "  CONSTRAINT `FK_p06cong2injx54ipykoegys3w` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`)\n" +
                ") ENGINE=InnoDB DEFAULT CHARSET=utf8";

        System.out.println();
    }

}
