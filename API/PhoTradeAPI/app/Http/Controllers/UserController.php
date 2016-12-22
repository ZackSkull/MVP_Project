<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;

use App\Http\Requests;

use App\User;

use Hash;
use DB;
use Auth;

class UserController extends Controller
{
    function doRegister (Request $request) {
    	$_userExist = User::where('email', $request['email'])->get()->first();
    	if ($_userExist == null) {
	    	$_userDatas = array(
	    		'username' => $request['username'],
	    		'email'    => $request['email'],
	    		'password' => Hash::make($request['password'])
	    	);

	    	$_user = new User;
	    	$_user::create($_userDatas);

	    	return response()->json(['message'=> 'Register Success.', 'code'=> '201']);    		
    	} else {
    		return response()->json(['message'=> 'Sorry, email already exist.', 'code'=> '401']);
    	}
    }

    function doLogin (Request $request) {
    	$_userdatas = array(
    		'email'    => $request['email'],
			'password' => $request['password']
    	);

    	if(Auth::attempt($_userdatas))
    		return response()->json(['message'=> 'Login Success', 'code'=> '200']);
    	return response()->json(['message'=> 'Email and password does not match.', 'code'=> '401']);

    }
}
