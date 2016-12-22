<?php

namespace App;

use Illuminate\Database\Eloquent\Model;

class Message extends Model
{
    protected $primaryKey = 'msgId';

    protected $fillable = [
		'msgSubject', 'msgText', 'msgReceiver', 'msgOwner'
	];

    protected $hidden = [
        'timestamps'
    ];
}
