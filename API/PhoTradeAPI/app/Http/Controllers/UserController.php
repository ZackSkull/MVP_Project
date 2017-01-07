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

			$_user = new User();
	    	$_user = User::create($_userDatas);

	    	return response()->json(['message'=> 'Register Success.', 'code'=> '201', 'user'=> $_user]);    		
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
		{
			$_userExist = Auth::user();
			if ($_userExist != null)
			{
    			return response()->json(['message'=> 'Login Success', 'code'=> '200', 'user'=> $_userExist]);
			}
		}
    	return response()->json(['message'=> 'Email and password does not match.', 'code'=> '401']);

    }

	function doUpdateProfile (Request $request) {
		$_userExist = User::where('id', $request['id'])->get()->first();
		if ($_userExist != null)
		{
			$_user = new User();
			User::where('id', $request['id'])
						->update([
								'username' => $request['username'],
								'name' => $request['name'],
								'email'    => $request['email'],
								'city' => $request['city'],
								'address' => $request['address'],
								'phone' => $request['phone'],
								'bio' => $request['bio'],
								'gender' => $request['gender']
							]);

			$_user = User::where('id', $request['id'])->get()->first();
			
			return response()->json(['message'=> 'Update Success', 'code'=> '201', 'user'=> $_user]);
		}
    	return response()->json(['message'=> 'Update Failed.', 'code'=> '401']);

    }

	function doUpdatePassword (Request $request) {
		$_userdatas = array(
    		'email'    => $request['email'],
			'password' => $request['password']
    	);

		if (Auth::attempt($_userdatas))
		{
			$_user = Auth::user();
			$_user->password = Hash::make($request['newPassword']);
			$_user->save();

			return response()->json(['message'=> 'Change Password Success', 'code'=> '201', 'user'=> $_user]);
		}
    	return response()->json(['message'=> 'Change Password Failed.', 'code'=> '401']);

    }
}
