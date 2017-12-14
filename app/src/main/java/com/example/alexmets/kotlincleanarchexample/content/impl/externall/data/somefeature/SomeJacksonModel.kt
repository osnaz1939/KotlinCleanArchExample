package com.example.alexmets.kotlincleanarchexample.content.impl.externall.data.somefeature

import com.fasterxml.jackson.annotation.JsonProperty

data class SomeJacksonModel(@JsonProperty("mInt") private final var mInt: Int,
                                     @JsonProperty("mString") private final var mString: String?) {

}