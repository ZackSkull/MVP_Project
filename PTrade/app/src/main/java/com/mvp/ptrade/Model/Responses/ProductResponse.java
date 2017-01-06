package com.mvp.ptrade.Model.Responses;

import com.mvp.ptrade.Model.Basic.Product;
import com.mvp.ptrade.Model.Basic.Response;

import java.util.List;

/**
 * Created by Zackzack on 04/01/2017.
 */

public class ProductResponse extends Response{
    private Product[] product;
    public Product[] getProduct() {
        return product;
    }
    public void setProduct(Product[] product) {
        this.product = product;
    }
}
