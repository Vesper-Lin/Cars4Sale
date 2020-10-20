package com.example.cars4sale.Parser;

import com.example.cars4sale.DataStructure.BSTSearch;

import java.util.Map;

import static com.example.cars4sale.DataStructure.BST.getHigherPrice;
import static com.example.cars4sale.DataStructure.BST.list_to_list;
import static com.example.cars4sale.DataStructure.BST.list_to_map;
import static com.example.cars4sale.DataStructure.BSTSearch.node;

public class ExpHigherPrice extends Exp {

    private int price;

    public ExpHigherPrice(int price) {
        this.price = price;
    }

    @Override
    public Map evaluate() {
        Map result = list_to_map(
                BSTSearch.readData_map(),
                list_to_list(
                        getHigherPrice(node(BSTSearch.readData_slist()).root, price)
                )
        );
        return result;
    }
}
