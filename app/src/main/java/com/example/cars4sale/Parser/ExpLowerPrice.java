package com.example.cars4sale.Parser;

import com.example.cars4sale.DataStructure.BSTSearch;

import java.util.Map;

import static com.example.cars4sale.DataStructure.BST.getHigherPrice;
import static com.example.cars4sale.DataStructure.BST.getLowerPrice;
import static com.example.cars4sale.DataStructure.BST.list_to_list;
import static com.example.cars4sale.DataStructure.BST.list_to_map;
import static com.example.cars4sale.DataStructure.BSTSearch.node;

public class ExpLowerPrice extends Exp {
    private int price;

    public ExpLowerPrice(int price) {
        this.price = price;
    }

    @Override
    public Map evaluate() {
        Map result = list_to_map(
                BSTSearch.readData_map(),
                list_to_list(
                        getLowerPrice(node(BSTSearch.readData_slist()).root, price)
                )
        );
        return result;
    }
}
