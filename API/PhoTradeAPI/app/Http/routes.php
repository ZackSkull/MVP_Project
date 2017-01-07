<?php

/*
|--------------------------------------------------------------------------
| Application Routes
|--------------------------------------------------------------------------
|
| Here is where you can register all of the routes for an application.
| It's a breeze. Simply tell Laravel the URIs it should respond to
| and give it the controller to call when that URI is requested.
|
*/

Route::get('/', function () {
    return view('welcome');
});

Route::post('user/register', 'UserController@doRegister');

Route::post('user/login', 'UserController@doLogin');
Route::post('user/update', 'UserController@doUpdateProfile');

Route::get('product', 'ProductController@index');
Route::get('product/{id}', 'ProductController@show');
Route::post('product/store', 'ProductController@store');
Route::put('product/update/{id}', 'ProductController@update');
Route::delete('product/delete/{id}', 'ProductController@destroy');

Route::get('thread', 'ThreadController@index');
Route::get('thread/{id}', 'ThreadController@show');
Route::post('thread/store', 'ThreadController@store');
Route::put('thread/update/{id}', 'ThreadController@update');
Route::delete('thread/delete/{id}', 'ThreadController@destroy');

Route::get('spec', 'SpecDefaultController@index');
Route::get('spec/{id}', 'SpecDefaultController@show');
Route::post('spec/store', 'SpecDefaultController@store');
Route::put('spec/update/{id}', 'SpecDefaultController@update');
Route::delete('spec/delete/{id}', 'SpecDefaultController@destroy');