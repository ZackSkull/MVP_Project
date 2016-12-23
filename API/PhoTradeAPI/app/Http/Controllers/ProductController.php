<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use Illuminate\Database\Eloquent\Model;

use App\Http\Requests;
use App\Product;

class ProductController extends Controller
{
    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index()
    {
        $products = Product::all();
        return $products->toJson();
    }

    /**
     * Show the form for creating a new resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function create()
    {
        //
    }

    /**
     * Store a newly created resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @return \Illuminate\Http\Response
     */
    public function store(Request $request)
    {
        $_productExist = Product::where('prodName', $request['prodName'])->get()->first();
    	if ($_productExist == null) {
	    	$_productDatas = array(
	    		'prodName'  => $request['prodName'],
	    		'prodType'  => $request['prodType'],
	    		'prodBrand' => $request['prodBrand']
	    	);

	    	$_product = new Product;
	    	$_product::create($_productDatas);

	    	return response()->json(['message'=> 'Insert Product Success.', 'code'=> '201']);    		
    	} else {
    		return response()->json(['message'=> 'Sorry, product name already exist.', 'code'=> '401']);
    	}
    }

    /**
     * Display the specified resource.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function show($id)
    {
        $product = Product::where('prodId', $id)->get();
        return $product->toJson();
    }

    /**
     * Show the form for editing the specified resource.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function edit($id)
    {
        //
    }

    /**
     * Update the specified resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function update(Request $request, $id)
    {
        $_productExist = Product::where('prodId', $id)->get()->first();
    	if ($_productExist != null) {
	    	$_productExist->prodName = $request['prodName'];
	    	$_productExist->prodType = $request['prodType'];
	    	$_productExist->prodBrand = $request['prodBrand'];

            $_productExist->save();

	    	return response()->json(['message'=> 'Update Product Success.', 'code'=> '201']);    		
    	} else {
    		return response()->json(['message'=> 'Sorry, product not exist.', 'code'=> '401']);
    	}
    }

    /**
     * Remove the specified resource from storage.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function destroy($id)
    {
        $_productExist = Product::where('prodId', $id)->get()->first();
    	if ($_productExist != null) {
            $_productExist->delete();

	    	return response()->json(['message'=> 'Product has been deleted.', 'code'=> '201']);    		
    	} else {
    		return response()->json(['message'=> 'Sorry, product not exist.', 'code'=> '401']);
    	}
    }
}
