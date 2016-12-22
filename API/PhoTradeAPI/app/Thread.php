<?php

namespace App;

use Illuminate\Database\Eloquent\Model;

class Thread extends Model
{
    protected $primaryKey = 'trId';

    protected $fillable = [
		'trProdId', 'trUser', 'trUserBuy', 'trStatus', 'trLat', 'trLong'
	];

    protected $hidden = [
        'timestamps'
    ];

    public function products()
    {
        return $this->hasOne(Product::class);
    }
}
