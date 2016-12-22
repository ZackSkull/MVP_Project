<?php

namespace App;

use Illuminate\Database\Eloquent\Model;

class SpecDefault extends Model
{
    protected $primaryKey = 'sdId';

    protected $fillable = [
		'sdGroup', 'sdLabel'
	];

    protected $hidden = [
        'timestamps'
    ];
}
