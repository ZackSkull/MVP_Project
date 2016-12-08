<?php

namespace App;

use Illuminate\Database\Eloquent\Model;

class Thread extends Model
{
    protected $fillable = [
		'trProdId', 'trUser', 'trUserBuy', 'trStatus', 'trLat', 'trLong'
	];

    protected $hidden = [
        'timestamps'
    ];
}
