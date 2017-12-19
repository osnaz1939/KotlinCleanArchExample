package com.example.alexmets.kotlincleanarchexample.content.impl.externall.data.somefeature

import com.fasterxml.jackson.annotation.JsonProperty

data class SomeJacksonModel(@JsonProperty("mInt") final var mInt: Int,
                            @JsonProperty("mString") final var mString: String?) {

}