<?php

namespace App;

use Illuminate\Database\Eloquent\Model;

class Product extends Model
{
    protected $fillable = [
		'prodName', 'prodType', 'prodBrand'
	];

    protected $hidden = [
        'timestamps'
    ];

    public function thread()
    {
        return $this->belongsTo(Thread::class);
    }
}
