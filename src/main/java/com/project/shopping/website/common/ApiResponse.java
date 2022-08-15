package com.project.shopping.website.common;

import java.time.LocalDateTime;

public class ApiResponse {
   private final boolean success;
   private final String message;


   public ApiResponse(boolean success, String message) {
      this.success = success;
      this.message = message;
   }

   @Override
   public String toString() {
      return "ApiResponse{" +
              "success=" + success +
              ", message='" + message + '\'' +
              '}';
   }

   public boolean isSuccess() {
      return success;
   }

   public String getMessage() {
      return message;
   }

}
