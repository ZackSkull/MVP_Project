<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use Illuminate\Database\Eloquent\Model;

use App\Http\Requests;
use App\Thread;

class ThreadController extends Controller
{
    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index()
    {
        $thread = Thread::all();
        return $thread->toJson();
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
        // $_threadExist = Thread::where('trId', $request['trProdId'])->get()->first();
    	// if ($_threadExist == null) {
	    	$_threadDatas = array(
	    		'trProdId'  => $request['trProdId'],
	    		'trUser'    => $request['trUser'],
	    		'trUserBuy' => $request['trUserBuy'],
	    		'trStatus' => $request['trStatus'],
	    		'trLat' => $request['trLat'],
	    		'trLong' => $request['trLong']
	    	);

	    	$_thread = new Thread;
	    	$_thread::create($_threadDatas);

	    	return response()->json(['message'=> 'Insert Product Success.', 'code'=> '201']);    		
    	// } else {
    	// 	return response()->json(['message'=> 'Sorry, product name already exist.', 'code'=> '401']);
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
        $thread = Thread::where('trId', $id)->get();
        return $thread->toJson();
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
        $_threadExist = Thread::where('trId', $request['trProdId'])->get()->first();
    	if ($_threadExist != null) {
	    	$_threadDatas = array(
	    		'trProdId'  => $request['trProdId'],
	    		'trUser'    => $request['trUser'],
	    		'trUserBuy' => $request['trUserBuy'],
	    		'trStatus' => $request['trStatus'],
	    		'trLat' => $request['trLat'],
	    		'trLong' => $request['trLong']
	    	);

	    	$_thread = new Thread;
	    	$_thread::create($_threadDatas);

	    	return response()->json(['message'=> 'Update Thread Success.', 'code'=> '201']);    		
    	} else {
    		return response()->json(['message'=> 'Sorry, Thread not exist.', 'code'=> '401']);
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
        $_threadExist = Thread::where('trId', $request['trProdId'])->get()->first();
    	if ($_threadExist != null) {
            $_threadExist->delete();

	    	return response()->json(['message'=> 'Thread  has been deleted.', 'code'=> '201']);    		
    	} else {
    		return response()->json(['message'=> 'Sorry, Thread not exist.', 'code'=> '401']);
    	}
    }
}
