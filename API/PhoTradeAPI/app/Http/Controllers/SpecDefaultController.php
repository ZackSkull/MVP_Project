<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use Illuminate\Database\Eloquent\Model;

use App\Http\Requests;
use App\SpecDefault;

class SpecDefaultController extends Controller
{
    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index()
    {
        $specDefault = SpecDefault::all();
        return $specDefault->toJson();
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
        // $_sepDefaultExist = Product::where('sdGroup', $request['sdGroup'])->get()->first();
    	// if ($_sepDefaultExist == null) {
	    	$_sepDefaultDatas = array(
	    		'sdGroup' => $request['sdGroup'],
	    		'sdLabel' => $request['sdLabel']
	    	);

	    	$_specDefault = new SpecDefault;
	    	$_specDefault::create($_sepDefaultDatas);

	    	return response()->json(['message'=> 'Insert Spec Default Success.', 'code'=> '201']);    		
    	// } else {
    	// 	return response()->json(['message'=> 'Sorry, Spec Default name already exist.', 'code'=> '401']);
    	// }
    }

    /**
     * Display the specified resource.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function show($id)
    {
        $specDefault = SpecDefault::where('sdId', $id)->get();
        return $specDefault->toJson();
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
        $_specDefaultExist = SpecDefault::where('sdId', $id)->get()->first();
    	if ($_specDefaultExist != null) {
	    	$_specDefaultExist->sdGroup = $request['sdGroup'];
	    	$_specDefaultExist->sdLabel = $request['sdLabel'];

            $_specDefaultExist->save();

	    	return response()->json(['message'=> 'Update Spec Default Success.', 'code'=> '201']);    		
    	} else {
    		return response()->json(['message'=> 'Sorry, Spec Default not exist.', 'code'=> '401']);
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
        $_specDefaultExist = Product::where('sdId', $id)->get()->first();
    	if ($_specDefaultExist != null) {
            $_specDefaultExist->delete();

	    	return response()->json(['message'=> 'Update Spec Default Success.', 'code'=> '201']);    		
    	} else {
    		return response()->json(['message'=> 'Sorry, Spec Default not exist.', 'code'=> '401']);
    	}
    }
}
